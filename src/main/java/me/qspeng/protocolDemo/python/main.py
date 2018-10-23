import demo_pb2
# person = demo_pb2.Person()
address_book = demo_pb2.AddressBook()
person = address_book.people.add()

person.id = 1234
person.name = "John Doe"
person.email = "jdoe@example.com"
phone = person.phones.add()
phone.number = "555-4321"
phone.type = demo_pb2.Person.HOME

serialize_string = address_book.SerializeToString()

print serialize_string
print "-------------------"

address_book_retrieve = demo_pb2.AddressBook()
address_book_retrieve.ParseFromString(serialize_string)

print address_book_retrieve.people
