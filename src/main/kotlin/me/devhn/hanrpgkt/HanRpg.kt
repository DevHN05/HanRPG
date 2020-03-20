package me.devhn.hanrpgkt

import kr.heartpattern.spikot.SpikotPlugin
import kr.heartpattern.spikot.command.Command
import kr.heartpattern.spikot.command.Root
import kr.heartpattern.spikot.command.dsl.Description
import kr.heartpattern.spikot.module.AbstractModule
import kr.heartpattern.spikot.module.Module
import me.devhn.hanrpgkt.etc.Text
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.annotation.dependency.Dependency
import org.bukkit.plugin.java.annotation.plugin.Plugin

@Plugin(name = "hanrpg", version = "1.0.0")
@Dependency("Spikot")
class HanRpg: SpikotPlugin()

@Module
class WelcomeModule: AbstractModule() {
    override fun onEnable() {
        logger.info("[HanRPG] 플러그인이 작동됩니다.")
    }

    override fun onDisable() {
        logger.info("[HanRPG] 플러그인이 작동을 멈췄습니다.")
    }
}

@Root
open class RootCommand : Command() {
    companion object : Description({
        name = setOf("hr")
        usage = "§3§l[ §4§l! §3§l] §f§l/hr [command]"

        childs {
            add<HelpCommand>()
            add<ItemCommand>()
            add<MonsterCommand>()
        }

        completer {
            Bukkit.getOnlinePlayers().map{ it.name }.filter{ it == this.args.last() }
        }
    })

    protected val cs : CommandSender by sender()

    override fun execute() {
        cs.sendMessage("")
        cs.sendMessage(HelpCommand.usage + HelpCommand.help)
        cs.sendMessage(ItemCommand.usage + ItemCommand.help)
        cs.sendMessage(MonsterCommand.usage + MonsterCommand.help)
    }
}

class HelpCommand : RootCommand() {
    companion object : Description({
        name = setOf("help")
        usage = Text.getUsage("help")
        help = Text.getDescription("help")
    })

    val cmd by arg(0).validate {
        when (it) {
            "item" -> {
                cs.sendMessage("")
                cs.sendMessage(ItemCommand.usage + ItemCommand.help)
                true
            } "monster" -> {
                cs.sendMessage("")
                cs.sendMessage(MonsterCommand.usage + MonsterCommand.help)
                true
            } else -> {
                cs.sendMessage("")
                cs.sendMessage("§c§l[ §4§l! §c§l] §7입력하신 명령어는 없는 명령어입니다.")
                cs.sendMessage(description.usage + description.help)
                false
            }
        }
    }

    override fun execute() {
    }
}

class ItemCommand : RootCommand() {
    companion object : Description({
        name = setOf("item")
        usage = Text.getUsage("item")
        help = Text.getDescription("item")
    })

    val cmd by arg(0).validate {
        when (it) {
            "create" -> {
                cs.sendMessage("")
                cs.sendMessage(Text.getUsage("item", "create") +
                               Text.getDescription("item", "create"))
                true
            } "set" -> {
                cs.sendMessage("")
                cs.sendMessage(Text.getUsage("item", "set") +
                               Text.getDescription("item", "set"))
                true
            } "remove" -> {
                cs.sendMessage("")
                cs.sendMessage(Text.getUsage("item", "remove") +
                               Text.getDescription("item", "remove"))
                true
            } else -> {
                cs.sendMessage("")
                cs.sendMessage(Text.getUsage("item", "create") +
                               Text.getDescription("item", "create"))
                cs.sendMessage(Text.getUsage("item", "set") +
                               Text.getDescription("item", "set"))
                cs.sendMessage(Text.getUsage("item", "remove") +
                               Text.getDescription("item", "remove"))
                false
            }
        }
    }

    override fun execute() {
    }
}

class MonsterCommand : RootCommand() {
    companion object : Description({
        name = setOf("monster", "mon")
        usage = Text.getUsage("monster")
        help = Text.getDescription("monster")
    })

    val cmd by arg(0).validate {
        when (it) {
            "create" -> {
                true
            } "remove" -> {
                true
            } else -> {
                cs.sendMessage("")
                cs.sendMessage("§c§l[ §4§l! §c§l] &7입력하신 명령어는 없는 명령어입니다.")
                cs.sendMessage(description.usage + description.help)
                false
            }
        }
    }

    override fun execute() {
    }
}