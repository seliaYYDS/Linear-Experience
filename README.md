# Linear Experience / 线性经验

[English](#english) | [中文](#中文)

---

<a name="english"></a>
## English

### Linear Experience Mod for Minecraft 1.20.1

A comprehensive Minecraft Forge mod that completely overhauls the vanilla non-linear experience system, providing multiple configurable experience calculation modes while maintaining full compatibility with all vanilla experience-related features.

---

### Features

#### 🎯 Core Experience Calculation Modes

- **STATIC Mode**: Fixed experience cost per level (same for all levels)
- **LINEAR Mode**: Linear progression (base cost + level × addition)
- **FORMULA Mode**: Custom mathematical formula using variables `base` and `level`

#### ⚙️ Configuration System
- TOML-based configuration file
- Hot-reload support
- Server-client synchronization
- Extensive customization options

#### 🔧 Technical Features
- Precise experience calculation (1000x precision)
- Full vanilla compatibility
- Player data persistence
- Safe mathematical expression parsing
- Automatic level-up detection

---

### Installation

1. Download the latest release from the releases page
2. Place the `.jar` file in your Minecraft `mods` folder
3. Launch Minecraft with Forge 1.20.1

---

### Configuration

Configuration file location: `config/linear-xp.toml`

#### Basic Configuration
```toml
[general]
enableXpCalculationModifier = true
calculateMode = "STATIC"  # Options: "STATIC", "LINEAR", "FORMULA"
```

#### Mode-Specific Settings

**STATIC Mode:**
```toml
[static]
staticModeXpNeeded = 100  # Fixed XP required per level
```

**LINEAR Mode:**
```toml
[linear]
linearBaseXp = 100        # Base XP cost
LinearXpAddition = 1      # XP increase per level
```

**FORMULA Mode:**
```toml
[formula]
formula = "base+((level*level)*10)"  # Custom formula
formulaBaseXp = 100                  # Base value for formula
```

---

### Usage

#### In-Game Commands
- All vanilla `/xp` commands work normally
- Experience calculation is automatically handled by the mod
- No additional commands required

#### Experience Display
- Experience bar shows progress based on configured mode
- Level-up happens automatically when requirements are met
- Precise calculation prevents rounding errors

---

### Compatibility

✅ **Fully Compatible With:**
- Vanilla experience orbs
- Enchanting tables and anvils
- Brewing stands
- All `/xp` commands
- Experience-related advancements
- Multiplayer servers

---

### Development

#### Building from Source
```bash
gradlew build
```

#### Project Structure
```
src/main/java/celia/adwadg/linearxp/
├── LinearXp.java              # Main mod class
├── Config/ExpConfig.java      # Configuration system
├── ExperienceManager.java     # Mode management
├── Utils/
│   ├── ExperienceCalculator.java  # Core calculation logic
│   └── ExpUtils.java          # Utility functions
├── Handler/
│   ├── ExpHandler.java        # Experience event handling
│   ├── ExpDisplayHandler.java # Experience bar updates
│   └── PlayerEvents.java      # Player lifecycle events
└── Capability/
    ├── AccuratedExp.java      # Precise experience storage
    └── CapabilityRegistry.java # Capability registration
```

---

### License

This project is licensed under the MIT License - see the LICENSE file for details.

---

### Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

---

<a name="中文"></a>
## 中文

### Linear Experience - Minecraft 1.20.1 线性经验模组

一个全面的 Minecraft Forge 模组，彻底改革了原版非线性经验系统，提供多种可配置的经验计算模式，同时保持与原版所有经验相关功能的完全兼容。

---

### 功能特性

#### 🎯 核心经验计算模式

- **STATIC 模式**：固定每级经验需求（所有等级相同）
- **LINEAR 模式**：线性增长（基础值 + 等级 × 增量）
- **FORMULA 模式**：使用变量 `base` 和 `level` 的自定义数学公式

#### ⚙️ 配置系统
- 基于 TOML 的配置文件
- 支持热重载
- 服务器-客户端同步
- 广泛的定制选项

#### 🔧 技术特性
- 精确经验计算（1000倍精度）
- 完全的原版兼容性
- 玩家数据持久化
- 安全的数学表达式解析
- 自动升级检测

---

### 安装方法

1. 从发布页面下载最新版本
2. 将 `.jar` 文件放入 Minecraft 的 `mods` 文件夹
3. 使用 Forge 1.20.1 启动 Minecraft

---

### 配置说明

配置文件位置：`config/linear-xp.toml`

#### 基础配置
```toml
[general]
enableXpCalculationModifier = true      # 是否启用经验计算修改
calculateMode = "STATIC"                # 选项："STATIC", "LINEAR", "FORMULA"
```

#### 模式特定设置

**STATIC 模式：**
```toml
[static]
staticModeXpNeeded = 100  # 每级所需的固定经验值
```

**LINEAR 模式：**
```toml
[linear]
linearBaseXp = 100        # 线性基础经验值
LinearXpAddition = 1      # 线性经验增量
```

**FORMULA 模式：**
```toml
[formula]
formula = "base+((level*level)*10)"  # 公式模式计算公式
formulaBaseXp = 100                  # 公式模式基础经验
```

---

### 使用方法

#### 游戏内命令
- 所有原版 `/xp` 命令正常工作
- 经验计算由模组自动处理
- 无需额外命令

#### 经验显示
- 经验条根据配置模式显示进度
- 满足要求时自动升级
- 精确计算避免舍入误差

---

### 兼容性

✅ **完全兼容：**
- 原版经验球
- 附魔台和铁砧
- 酿造台
- 所有 `/xp` 命令
- 经验相关进度
- 多人服务器

---

### 开发信息

#### 从源码构建
```bash
gradlew build
```

#### 项目结构
```
src/main/java/celia/adwadg/linearxp/
├── LinearXp.java              # 主模组类
├── Config/ExpConfig.java      # 配置系统
├── ExperienceManager.java     # 模式管理
├── Utils/
│   ├── ExperienceCalculator.java  # 核心计算逻辑
│   └── ExpUtils.java          # 工具函数
├── Handler/
│   ├── ExpHandler.java        # 经验事件处理
│   ├── ExpDisplayHandler.java # 经验条更新
│   └── PlayerEvents.java      # 玩家生命周期事件
└── Capability/
    ├── AccuratedExp.java      # 精确经验存储
    └── CapabilityRegistry.java # Capability 注册
```

---

### 许可证

本项目采用 MIT 许可证 - 详见 LICENSE 文件。

---

### 贡献

欢迎贡献！请随时提交拉取请求或为错误和功能请求打开问题。

---

### 常见问题

**Q: 模组会影响原版功能吗？**
A: 不会，模组设计为完全兼容原版所有功能。

**Q: 支持多人游戏吗？**
A: 是的，完全支持多人服务器。

**Q: 如何切换回原版经验系统？**
A: 在配置文件中设置 `enableXpCalculationModifier = false` 或删除模组。

**Q: 公式模式安全吗？**
A: 是的，使用安全的数学表达式解析器，不支持危险操作。

---

*最后更新：2024年*