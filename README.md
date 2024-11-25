[//]: <> (Thanks for the advice KiLAB, now I'm going to ice out the README even more)
[//]: <> (Don't worry, these are comments, they won't actually show on the readme :)

![Current version](https://img.shields.io/badge/version-DevBuild-green)

# DNeko

Based from `Gensh1n Cilent`

专注于绕过吉吉岛服务器的 1.20.4 高版本客户端

# 系统要求

系统: Windows

软件: Java 21, Minecraft 1.20.4 并且安装了 Fabric 和 Fabric API

# 构建并出击吉吉岛 (阻止妖猫开宝马)

1. 使用 `git clone https://github.com/DarkMeowTeam/DNeko` 或者其它方式下载源代码.
2. 打开当前目录.
3. 运行 `./gradlew build`.
4. 在构建成功后 打开 `build\libs` 目录
5. 将其复制到一个 Minecraft 1.20.4 Fabric 客户端 `mods` 文件中 (必须与 `ViaFabricPlus` 配合 否则无法进入吉吉岛)
6. 将 `ViaFabricPlus` 版本设置为 `1.18-1.18.1`
7. 通过 `Myth` 脱盒启动代码 然后根据提示进行连接
8. 首次进入游戏后 请按下键盘上的 `R-SHIFT` `(右SHIFT)` 打开 `ClickGUI`

# LowIQ疑难解答

> Q: 为什么客户端启动不了
>
> A: 请检查游玩JDK版本 请确保他是JDK21 (不支持JDK17)

> Q: 为什么无法构建
>
> A: 请检查Gradle所使用的JDK版本 并确保他是JDK21

> Q: 我该怎么给模块绑定按键
> 
> A: 您可以打开聊天栏并输入 `.bind 模块名 按键名称` 例如 `.bind kill-aura r`

> Q: 我该怎么编辑 HUD
> 
> A: 在 ClickGUI 中创建  在聊天栏中调整位置

> Q: 进入游戏 10 ~ 30 秒后被封
> 
> A: 请检查是否开启 `Protocol` 以及是否曾被封禁过 如果是 请更换 IP地址 优化
