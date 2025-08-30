package org.example;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Students implement this method to return the exact outputs defined in README.
 */
public class ReplyService {

    public static final Map<String, ArrayList<String>> replyControl = Map.ofEntries(
            Map.entry("hi", new ArrayList<>(Arrays.asList(
                    "Hello. How may I assist you today?",
                    "Hey there! 😊 How can I help?",
                    "Hello. How can I help?"))),

            Map.entry("hello", new ArrayList<>(Arrays.asList(
                    "Hello. How may I assist you today?",
                    "Hi! 👋 What’s up?",
                    "Hello. How can I help?"))),

            Map.entry("how are you", new ArrayList<>(Arrays.asList(
                    "I am functioning properly. How may I assist you?",
                    "Doing great! 😄 How can I help?",
                    "I’m good. How can I help?"))),

            Map.entry("i need help", new ArrayList<>(Arrays.asList(
                    "I can assist with that. Please provide more details.",
                    "I’ve got you! 🙂 Tell me a bit more.",
                    "Share details; I’ll help."))),

            Map.entry("can you help me with my account", new ArrayList<>(Arrays.asList(
                    "Certainly. Please describe the account issue.",
                    "Sure thing! 😊 What’s wrong with the account?",
                    "Describe the account issue…"))),

            Map.entry("thanks", new ArrayList<>(Arrays.asList(
                    "You are welcome.",
                    "Anytime! 🙌",
                    "You’re welcome."))),

            Map.entry("bye", new ArrayList<>(Arrays.asList(
                    "Goodbye.",
                    "See you later! 👋",
                    "Goodbye."))),

            Map.entry("what is your name", new ArrayList<>(Arrays.asList(
                    "I am your virtual assistant.",
                    "I’m your helper bot 🤖",
                    "I’m your assistant."))),

            Map.entry("", new ArrayList<>(Arrays.asList(
                    "Please say something.",
                    "Please say something.",
                    "Please say something.")))
    );

    public String reply(String message, ReplyType type) {
        // TODO: Implement mapping according to README canonical expectations.

        // Requirements:
        // - null or blank -> "Please say something."
        // - For known messages, return exact string for each ReplyType.
        // - For unknown messages, return the 'any other text' mapping.

//        Enum mapping to index
        int replyIndex;
        if (type == ReplyType.FORMAL) {
            replyIndex = 0;
        }
        else if (type == ReplyType.FRIENDLY) {
            replyIndex = 1;
        }
        else {
            replyIndex = 2;
        }

//        Null message case
        if (message == null) {
            return replyControl.get("").get(replyIndex);
        }

//        Message cleaning
        String lowerMessage = message.toLowerCase();
        String lowerMessageStrip = lowerMessage.strip().replaceAll("\\s+", " ");
        String lowerMessageStripClean = lowerMessageStrip.replaceAll("\\{Punct}+$", "");

//        Default Response
        ArrayList<String> defaultResponses = new ArrayList<>(Arrays.asList(
                        "Could you clarify your request?",
                        "Could you tell me more?",
                        "Please clarify."));

        return replyControl.getOrDefault(lowerMessageStripClean, defaultResponses).get(replyIndex);
    }
}
