/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2018, oplosthee <https://github.com/oplosthee>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.brooklyn.smartmetronome;

import net.runelite.api.SoundEffectVolume;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("metronome")
public interface SmartMetronomeConfig extends Config
{
	int VOLUME_MAX = SoundEffectVolume.HIGH;

	@ConfigSection(
		name = "Settings",
		description = "Smart Metronome Settings",
		position = 0
	)
	String settingsSection = "Settings";

	@ConfigItem(
		keyName = "tickCount",
		name = "Tick count",
		description = "Configures the tick on which a sound will be played.",
		section = settingsSection
	)
	default int tickCount()
	{
		return 1;
	}

	@Range(
		max = VOLUME_MAX
	)
	@ConfigItem(
		keyName = "tickVolume",
		name = "Tick volume",
		description = "Configures the volume of the tick sound. A value of 0 will disable tick sounds.",
		section = settingsSection
	)
	default int tickVolume()
	{
		return SoundEffectVolume.MEDIUM_HIGH;
	}

	@Range(
		max = VOLUME_MAX
	)
	@ConfigItem(
		keyName = "tockVolume",
		name = "Tock volume",
		description = "Configures the volume of the tock sound. A value of 0 will disable tock sounds.",
		section = settingsSection
	)
	default int tockVolume()
	{
		return SoundEffectVolume.MUTED;
	}

	@ConfigItem(
		keyName = "smartMetronome",
		name = "Enable Smart Metronome",
		description = "Enables location/activity specific metronome. Disable for normal metronome.",
		position = -2,
		section = settingsSection
	)
	default boolean smartMetronome()
	{
		return true;
	}
}