/*
 * Copyright 2021 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.qsl.registry.attachment.impl;

import java.util.Optional;

import com.mojang.serialization.Codec;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ConstantDefaultRegistryEntryAttachmentImpl<R, V> extends RegistryEntryAttachmentImpl<R, V> {
	private final V defaultValue;

	public ConstantDefaultRegistryEntryAttachmentImpl(Registry<R> registry, Identifier id, Class<V> valueClass, Codec<V> codec, Side side,
	                                                  V defaultValue) {
		super(registry, id, valueClass, codec, side);
		this.defaultValue = defaultValue;
	}

	@Override
	protected Optional<V> getDefaultValue(R entry) {
		return Optional.ofNullable(this.defaultValue);
	}
}