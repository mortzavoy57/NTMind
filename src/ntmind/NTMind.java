package ntmind;

import arc.*;
import arc.util.*;
import ntmind.content.NTMBlocks;
import ntmind.content.NTMItems;
import ntmind.content.NTMTechTree;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class NTMind extends Mod{

    public NTMind(){
        Log.info("Loaded ExampleJavaMod constructor.");
    }

    public void loadContent(){
        NTMItems.load();
        NTMBlocks.load();
        NTMTechTree.load();

        Log.info("NTMind Loaded Complete.");
    }

}
