package celia.adwadg.linearxp.Handler;

import celia.adwadg.linearxp.ExperienceManager;
import celia.adwadg.linearxp.LinearXp;
import celia.adwadg.linearxp.Utils.ExperienceCalculator;
import celia.adwadg.linearxp.Utils.ExpUtils;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LinearXp.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExpHandler {

    @SubscribeEvent
    public static void onXpChange(PlayerXpEvent.XpChange event) {
        var player = event.getEntity();
        var level = player.experienceLevel;
        int originalAmount = event.getAmount();

        if (originalAmount <= 0) return;

        // 计算浮点数结果
        double doubleResult = ExperienceCalculator.MultiplyXpDouble(originalAmount, level);
        // 转为精确经验值（乘以1000）
        long accuratedAmount = (long) (doubleResult * 1000.0);

        /*LinearXp.LOGGER.debug("原始经验: {}, 浮点结果: {}, 精确经验值: {}, 当前等级: {}, 模式: {}",
                originalAmount, doubleResult, accuratedAmount, level, ExperienceManager.XPMODE);*/

        // 增加精确经验值
        ExpUtils.addAccuratedExp(player, accuratedAmount);

        // 获取增加后的精确经验值和实际经验值
        long currentAccurated = ExpUtils.getAccuratedExpValue(player);
        int actualExp = ExpUtils.getActualExp(player);

        ExpDisplayHandler.updatePlayerExpBar(event.getEntity());

        LinearXp.LOGGER.debug("增加后 - 精确经验: {}, 实际经验: {}",
                currentAccurated, actualExp);

        // 阻止原版经验系统处理这个事件
        event.setAmount(0);
    }
}
