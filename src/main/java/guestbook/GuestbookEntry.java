/*
 * Copyright 2014-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guestbook;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import org.springframework.util.Assert;

/**
 * A guestbook entry. An entity as in the Domain Driven Design context. Mapped onto the database using JPA annotations.
 *
 * @author Paul Henke
 * @author Oliver Drotbohm
 * @see
 * <a href="https://en.wikipedia.org/wiki/Domain-driven_design#Building_blocks">(Wikipedia) Domain-Driven-Design </a>
 */
@Entity
class GuestbookEntry {

	private @Id @GeneratedValue Long id;
	private final String name, text;
	private final String color;
	private final LocalDateTime date;

	/**
	 * Creates a new {@link GuestbookEntry} for the given name and text.
	 *
	 * @param name must not be {@literal null} or empty
	 * @param text must not be {@literal null} or empty
	 */
	public GuestbookEntry(String name, String text, String color) {

		Assert.hasText(name, "Name must not be null or empty!");
		Assert.hasText(text, "Text must not be null or empty!");

		this.name = name;
		this.text = text;
		this.color = color;
		this.date = LocalDateTime.now();
	}

	@SuppressWarnings("unused")
	private GuestbookEntry() {
		this.color = null;
		this.name = null;
		this.text = null;
		this.date = null;
	}

	public String getName() {
		return name;
	}
	public String getColor() { return color; }

	public Long getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getText() {
		return text;
	}
}
