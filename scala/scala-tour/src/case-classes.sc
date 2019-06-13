case class Book(isbn: String)

val frankenstein = Book("123-456789")

case class Message(sender: String, recipient: String, body: String)
val message = Message("aaa@google.com", "zzz@google.com", "Hello")
message.sender
message.recipient
message.body

// compile error
//message.sender = "AAA@google.com"

val anotherMessage = Message("aaa@google.com", "zzz@google.com", "Hello")
val messageAreTheSame = message == anotherMessage

val otherMessage = anotherMessage.copy(sender = message.sender, recipient = "abc@google.com", body = "Bye")
otherMessage


abstract class Notification

case class Email(sourceEmail: String, title: String, body: String) extends Notification
case class SMS(sourceEmail: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

val emailFromJohn = Email("aaa@google.com", "Greeting from aaa", "Hello!!")
val title = emailFromJohn.title

def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      "You got an email from" + email + " with title " + title
    case SMS(number, message) =>
      "You got an SMS from " + number + "! Message: " + message
    case VoiceRecording(name, link) =>
      "you received a Voice Recording from " + name + "! Click the link to hear it: " + link
  }
}

val someSms = SMS("0101112222", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")


showNotification(someSms)
showNotification(someVoiceRecording)
