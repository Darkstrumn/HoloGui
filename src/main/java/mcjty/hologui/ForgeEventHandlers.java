package mcjty.hologui;

import mcjty.hologui.config.GuiConfiguration;
import mcjty.hologui.config.HoloGuiConfiguration;
import mcjty.hologui.gui.HoloGuiSounds;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandlers {

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> sounds) {
        HoloGuiSounds.init(sounds.getRegistry());
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        GuiConfiguration.init(HoloGuiConfiguration.mainConfig);

        if (HoloGuiConfiguration.mainConfig.hasChanged()) {
            HoloGuiConfiguration.mainConfig.save();
        }
    }
}
