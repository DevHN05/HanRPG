package me.devhn.hanrpgkt.etc

object Text {
    fun getUsage(cmd : String) : String {
        return when (cmd) {
              "help"    -> {
                "§c§l[ §4§l> §c§l] §f§l/hr help [명령어]"
            } "item"    -> {
                "§c§l[ §4§l> §c§l] §f§l/hr item [명령어]"
            } "monster" -> {
                "§c§l[ §4§l> §c§l] §f§l/hr monster [명령어]"
            } else      -> {
                ""
            }
        }
    }

    fun getUsage(cmd : String, arg1 : String) : String {
        return when (cmd) {
            "item" -> {
                return when (arg1) {
                    "create" -> {
                        "§c§l[ §4§l> §c§l] §f§l/hr item create [이름]"
                    } "set" -> {
                        "§c§l[ §4§l> §c§l] §f§l/hr item set [이름]"
                    } "remove" -> {
                        "§c§l[ §4§l> §c§l] §f§l/hr item remove [이름]"
                    } else -> {
                        getUsage("item")
                    }
                }
            } else -> {
                ""
            }
        }
    }

    fun getDescription(cmd : String) : String {
        return when (cmd) {
              "help"    -> {
                "§7: 명령어 관련 도움말을 확인할 수 있습니다."
            } "item"    -> {
                "§7: 아이템 관련 도움말을 확인할 수 있습니다."
            } "monster" -> {
                "§7: 몬스터 관련 도움말을 확인할 수 있습니다."
            } else      -> {
                ""
            }
        }
    }

    fun getDescription(cmd : String, arg1 : String) : String {
        return when (cmd) {
            "item" -> {
                return when (arg1) {
                    "create" -> {
                        "§7: 아이템을 생성할 수 있습니다."
                    } "set" -> {
                        "§7: 아이템을 설정할 수 있습니다."
                    } "remove" -> {
                        "§7: 아이템을 삭제할 수 있습니다."
                    } else -> {
                        getDescription("item")
                    }
                }
            } else -> {
                ""
            }
        }
    }
}