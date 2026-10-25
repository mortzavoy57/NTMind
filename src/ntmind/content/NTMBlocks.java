package ntmind.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.production.GenericCrafter;
import ntmind.content.NTMItems;
import mindustry.world.blocks.environment.*;

import static mindustry.type.ItemStack.with;

public class NTMBlocks {
    public static Block
            /**oreBlocks*/
            oreIron,
            /**crafting*/
            ironSmelter, steelSmelter, vibraniumSmelter,
            /**Power*/
            thermoNuclearReactor;

    public static void load() {
        /**oreBlocks*/
        oreIron = new OreBlock("ore-iron", NTMItems.ironraw) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        /**crafting*/
        ironSmelter = new GenericCrafter("iron-smelter") {{
            requirements(Category.crafting, with(
                    Items.lead, 55,
                    Items.graphite, 20,
                    Items.titanium, 30
            ));

            size = 2;
            health = 190;
            craftTime = 60f;
            hasPower = true;
            hasLiquids = false;

            consumePower(1.5f);
            consumeItem(NTMItems.ironraw, 3);
            outputItems = with(NTMItems.iron, 2);

            craftEffect = Fx.pulverizeMedium;
        }};

        steelSmelter = new GenericCrafter("steel-smelter") {{
            requirements(Category.crafting, with(
                    NTMItems.iron, 70,
                    Items.graphite, 40,
                    Items.titanium, 50
            ));

            size = 2;
            health = 300;
            craftTime = 90f;
            hasPower = true;
            hasLiquids = false;

            consumePower(2f);
            consumeItems(with(NTMItems.iron, 2, Items.coal, 1));
            outputItems = with(NTMItems.steel, 2);

            craftEffect = Fx.pulverizeMedium;
        }};

        vibraniumSmelter = new GenericCrafter("vibranium-smelter") {{
            requirements(Category.crafting, with(
                    NTMItems.steel, 100,
                    Items.graphite, 50,
                    Items.titanium, 60,
                    Items.plastanium, 30,
                    Items.surgeAlloy, 28,
                    Items.thorium, 20
            ));

            size = 3;
            health = 340;
            craftTime = 300f;
            hasPower = true;
            hasLiquids = false;

            consumePower(4f);
            consumeItems(with(NTMItems.steel, 5, Items.plastanium, 3, Items.surgeAlloy, 2, Items.thorium, 4));
            outputItems = with(NTMItems.vibranium, 1);

            craftEffect = Fx.smeltsmoke;
        }};

        /**Power*/
        thermoNuclearReactor = new NuclearReactor("thermo-nuclear-reactor") {{
            requirements(Category.power, with(
                    NTMItems.steel, 1000,
                    Items.metaglass, 440,
                    Items.graphite, 510,
                    Items.thorium, 250,
                    Items.silicon, 300,
                    Items.surgeAlloy, 320
            ));
            size = 5;
            health = 1950;
            itemDuration = 1800f;
            powerProduction = 160f;
            heating = 0.05f;
            coolantPower = 0.15f;

            hasPower = true;
            hasItems = true;
            hasLiquids = true;

            consumeItem(Items.thorium);
            consumeLiquid(Liquids.water, 2f).update(false);
        }};
    }
}

