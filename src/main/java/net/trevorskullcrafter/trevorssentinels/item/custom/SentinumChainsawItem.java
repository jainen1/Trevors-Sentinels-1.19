package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.ShardEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SentinumChainsawItem extends AxeItem {
    public SentinumChainsawItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.BLOCKS, 1.0F, 1.0F);

            ShardEntity shardEntity = new ShardEntity(world, user);
            shardEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.0f, 1.0f);
            world.spawnEntity(shardEntity);

            user.sendMessage(Text.literal("Pew!").formatted(Formatting.GRAY),true);
            itemStack.damage(2, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this,10);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        /*if(world != null){
            String subtitle = "ahh the pepeloni, pepeloni. you know the pepeloni? the nooo one. i always, i always order the, the domino. domino pepeloni and without pepeloni. i always order the pepeloni and without pepeloni. pepeloni! i like pepeloni, yeah. i always, i always order the, the cheese- cheese pan. ahh how can i explain? i can explain by my drawing! i always order like the cheese pan that it has cheese on here, this part, the ear. ear of pizza. and then, i order- wh- when i order pepeloni, the ear- it always have a pepeloni on h- on a top, but i pick up these... away! cause i don't eat it. and then i eat the cheese pan pizza. okay? you understand? understandable! pepeloni! yes.";
            long endTime = 0;

            if(endTime <= world.getTime()){
                endTime = world.getTime() + subtitle.length();
            }

            char[] subtitleChars = subtitle.toCharArray();
            tooltip.add(Text.literal("~" +
                    subtitleChars[(int) (endTime - world.getTime())] +
                    subtitleChars[(int) (endTime - world.getTime() + 1)] +
                    subtitleChars[(int) (endTime - world.getTime() + 2)] +
                    subtitleChars[(int) (endTime - world.getTime() + 3)] +
                    subtitleChars[(int) (endTime - world.getTime() + 4)] +
                    subtitleChars[(int) (endTime - world.getTime() + 5)] +
                    "~").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("Time: "+(endTime - world.getTime())));
        }*/
        tooltip.add(Text.literal("Right click to fling").formatted(Formatting.RED));
        tooltip.add(Text.literal("sentinum shards at enemies!").formatted(Formatting.RED));
    }
}