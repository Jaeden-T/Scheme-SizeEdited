package mindustry.game;

import arc.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.input.*;

public class SchemeSize extends Mod{

    public SchemeSize(){
        Events.on(ClientLoadEvent.class, e -> {
            //wait 10 secs, because... idk
            Time.runTask(10f, () -> {
                Vars.schematics = new Schematics512();
                Vars.schematics.loadSync();

                // Change Input
                if(Vars.mobile){
                    Vars.control.setInput(new MobileInput512());
                }else{
                    Vars.control.setInput(new DesktopInput512());
                }

                Log.info(Vars.schematics);
                Log.info(Vars.mobile);
                Log.info(Vars.control.input);
            });
        });
    }
}