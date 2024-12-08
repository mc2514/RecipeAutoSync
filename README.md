# DiscoverRecipe Minecraft Java版 Spigot插件

## 插件介绍

**DiscoverRecipe** 插件是为我的个人 Minecraft 服务器定制的，参考了 **DiscoverRecipe by Bilicraft** 和 **Tweakin** 插件的功能。与原版 **DiscoverRecipe by Bilicraft** 插件不同，本插件不依赖于 NMS，因此能够跨版本使用，已在 Minecraft 1.20+ 版本上进行了测试。

与其他解锁配方插件不同，本插件不会在每次玩家进入服务器时自动检查并解锁其配方，而是通过命令手动解锁单个玩家或所有玩家的所有配方。这样可以有效减少服务器负担，优化性能。

此外，本插件支持与 **CMI** 自定义配方和 **CustomCrafting** 等插件兼容，玩家可以继续使用原版配方书，而无需依赖 GUI 配方书插件。

## 主要功能

- **跨版本支持**：本插件不依赖 NMS，支持 Minecraft 1.20+ 及以上版本。
- **性能优化**：避免每次玩家进入服务器时都检查配方解锁状态，改为通过命令手动解锁。
- **命令解锁配方**：
  - `/discoverRecipe`：为所有在线玩家解锁所有配方。
  - `/discoverRecipe run <player>`：为指定玩家解锁所有配方。
  - `/discoverRecipe reload`：重新加载插件的配方列表和配置。
- **兼容性**：支持 **CMI** 自定义配方、**CustomCrafting** 等插件。

## 安装方法

1. 下载插件 JAR 文件并将其放入 Minecraft 服务器的 `plugins` 目录。
2. 启动服务器。

## 插件支持

- **CMI**：支持自定义配方功能。
- **CustomCrafting**：支持自定义配方功能。
- 等等注册配方插件

