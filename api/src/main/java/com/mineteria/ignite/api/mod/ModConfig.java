/*
 * This file is part of Ignite, licensed under the MIT License (MIT).
 *
 * Copyright (c) Mineteria <https://mineteria.com/>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mineteria.ignite.api.mod;

import com.google.gson.Gson;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents the mod config, which is usually populated using
 * {@link Gson}.
 */
public final class ModConfig {
  private String id;
  private String version;
  private @Nullable String target;
  private @Nullable List<String> requiredDependencies;
  private @Nullable List<String> optionalDependencies;
  private @Nullable List<String> requiredMixins;

  public ModConfig() {}

  public ModConfig(final @NonNull String id,
                   final @NonNull String version,
                   final @Nullable String target,
                   final @Nullable List<String> requiredDependencies,
                   final @Nullable List<String> optionalDependencies,
                   final @Nullable List<String> requiredMixins) {
    this.id = id;
    this.version = version;
    this.target = target;
    this.requiredDependencies = requiredDependencies;
    this.optionalDependencies = optionalDependencies;
    this.requiredMixins = requiredMixins;
  }

  /**
   * Returns the mod identifier.
   *
   * @return The mod identifier
   */
  public final @NonNull String getId() {
    return this.id;
  }

  /**
   * Returns the mod version.
   *
   * @return The mod version
   */
  public final @NonNull String getVersion() {
    return this.version;
  }

  /**
   * Returns the mod target class.
   *
   * @return The mod target class
   */
  public final @Nullable String getTarget() {
    return this.target;
  }

  /**
   * Returns a list of required dependency identifiers.
   *
   * @return A list of required dependency
   */
  public final @Nullable List<String> getRequiredDependencies() {
    return this.requiredDependencies;
  }

  /**
   * Returns a list of optional dependency identifiers.
   *
   * @return A list of optional dependency
   */
  public final @Nullable List<String> getOptionalDependencies() {
    return this.optionalDependencies;
  }

  /**
   * Returns a list of required mixin configurations.
   *
   * @return A list of required mixins
   */
  public final @Nullable List<String> getRequiredMixins() {
    return this.requiredMixins;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(this.id, this.version, this.target, this.requiredDependencies, this.optionalDependencies, this.requiredMixins);
  }

  @Override
  public final boolean equals(final @Nullable Object other) {
    if (this == other) return true;
    if (!(other instanceof ModConfig)) return false;
    final ModConfig that = (ModConfig) other;
    return Objects.equals(this.id, that.id)
      && Objects.equals(this.version, that.version)
      && Objects.equals(this.target, that.target)
      && Objects.deepEquals(this.requiredDependencies, that.requiredDependencies)
      && Objects.deepEquals(this.optionalDependencies, that.optionalDependencies)
      && Objects.deepEquals(this.requiredMixins, that.requiredMixins);
  }

  @Override
  public final @NonNull String toString() {
    return "ModConfig{id=" + this.id +
      ", version=" + this.version +
      ", target=" + this.target +
      ", requiredDependencies=" + (this.requiredDependencies != null ? Arrays.toString(this.requiredDependencies.toArray(new String[0])) : "[]") +
      ", optionalDependencies=" + (this.optionalDependencies != null ? Arrays.toString(this.optionalDependencies.toArray(new String[0])) : "[]") +
      ", requiredMixins=" + (this.requiredMixins != null ? Arrays.toString(this.requiredMixins.toArray(new String[0])) : "[]") +
      "}";
  }
}