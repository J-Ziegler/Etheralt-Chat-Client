package userInteract;

import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/*
 * 
 * @author Ben Sixel
 *   Copyright 2015 Benjamin Sixel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

public class ChatBox extends VBox {
	
	//Boolean for whether the chat box is at the bottom.
	private SimpleBooleanProperty bottom = new SimpleBooleanProperty(false);
	
	/**
	 * Initiates a new ChatBox with width 500 and the default styling for a ChatBox as defined in the CSS file.
	 */
	public ChatBox() {
		
		this.setMaxWidth(500);
		this.setMinWidth(500);
		this.setPrefWidth(500);
		this.getStyleClass().add("chat-box");
		
	}
	
	/**
	 * Adds a new ChatText object contained within this ChatBox, with the desired colors and message.
	 * @param msg The message to display on the ChatText.
	 * @param color The color of the text.
	 * @param bgColor The color of the background.
	 */
	public void addText(String msg, String color, String bgColor) {
		this.getChildren().add(new ChatText(msg, color, bgColor));
	}
	
	/**
	 * Gets the ChatTexts as a list.
	 * @return A list containing all of the ChatTexts.
	 */
	public List<Node> getMessages() {
		return this.getChildren().stream()
				.filter(e -> e.getClass().equals(ChatText.class)).collect(Collectors.toList());
	}

	/**
	 * Adds an already built ChatText to this ChatBox.
	 * @param chatText The ChatText to add.
	 */
	public void addText(ChatText chatText) {
		this.getChildren().add(chatText);
	}
	
	/**
	 * Returns the bottom boolean.
	 * @return The boolean value 'bottom'.
	 */
	public Boolean getIsAtBottom() {
		return this.bottom.getValue();
	}
	
	/**
	 * Sets the bottom boolean to the given value.
	 * @param b The value being given to bottom.
	 */
	public void setIsAtBottom(boolean b) {
		this.bottom.set(b);
	}
	
}