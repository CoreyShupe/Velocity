/*
 * Copyright (C) 2018 Velocity Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.velocitypowered.proxy.tablist;

import com.velocitypowered.api.proxy.player.ChatSession;
import com.velocitypowered.api.proxy.player.TabList;
import com.velocitypowered.api.proxy.player.TabListEntry;
import com.velocitypowered.api.util.GameProfile;
import java.util.Optional;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;

public class VelocityTabListEntry implements TabListEntry {
  private final VelocityTabList tabList;
  private final GameProfile profile;
  private Component displayName;
  private int latency;
  private int gameMode;
  private @Nullable ChatSession session;

  public VelocityTabListEntry(VelocityTabList tabList, GameProfile profile,
                              Component displayName, int latency, int gameMode, @Nullable ChatSession session) {
    this.tabList = tabList;
    this.profile = profile;
    this.displayName = displayName;
    this.latency = latency;
    this.gameMode = gameMode;
    this.session = session;
  }

  @Override
  public @Nullable ChatSession getChatSession() {
    return this.session;
  }

  @Override
  public TabList getTabList() {
    return this.tabList;
  }

  @Override
  public GameProfile getProfile() {
    return this.profile;
  }

  @Override
  public Optional<Component> getDisplayNameComponent() {
    return Optional.ofNullable(displayName);
  }

  @Override
  public TabListEntry setDisplayName(@Nullable Component displayName) {
    this.displayName = displayName;
    return this;
  }

  @Override
  public int getLatency() {
    return this.latency;
  }

  @Override
  public TabListEntry setLatency(int latency) {
    this.latency = latency;
    return this;
  }

  @Override
  public int getGameMode() {
    return this.gameMode;
  }

  @Override
  public TabListEntry setGameMode(int gameMode) {
    this.gameMode = gameMode;
    return this;
  }

  protected void setChatSession(ChatSession session) {
    this.session = session;
  }
}
