package code
package model

import net.liftweb._
import json._
import JsonDSL._

import org.bson.types.ObjectId

class CardSpec extends MongoBaseSpec {
  "Card" should {
    "get set from json" in {
      val id = new ObjectId("5149f2b8e4b0199ea38f7b37")

      val json = """
      {
        "_id": "%s",
        "order_number": "1",
        "position": 0,
        "quantity": 1,
        "comments": [
          {
            "comment": "Hola",
            "created": 1000
          },
          {
            "comment": "Hola2",
            "created": 1000
          }
        ]
      }""".format(id.toString)

      val r = Card.createRecord
      r.setFieldsFromJValue(parse(json))

      val res = """class code.model.Card={quantity=1, order_number=1, _id=5149f2b8e4b0199ea38f7b37, position=0, comments=List(class code.model.Comment={comment=Hola, created=1000}, class code.model.Comment={comment=Hola2, created=1000})}"""

      r.toString should equal (res)
    }
  }
}
