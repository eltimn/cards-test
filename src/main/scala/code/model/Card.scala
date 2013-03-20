package code.model

import net.liftweb._
import mongodb.record._
import mongodb.record.field._
import record.field._

class Card private() extends MongoRecord[Card] with ObjectIdPk[Card] {
  override def meta = Card

  //fields
  object order_number extends StringField(this, "")
  object position extends IntField(this, 0) //stores most recent value from positions
  object quantity extends IntField(this, 0) //stores most recent value from positions


  //comments
  object comments extends BsonRecordListField(this, Comment)

}

object Card extends Card with MongoMetaRecord[Card] {
  override def collectionName = "cards"
}

class Comment private() extends BsonRecord[Comment] {
  def meta = Comment
  object comment extends StringField(this, "")
  object created extends LongField(this, System.currentTimeMillis)
}

object Comment extends Comment with BsonMetaRecord[Comment]
