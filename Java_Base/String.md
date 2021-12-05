# Java - 3


## String concatenation

* Strings are immutable
* characters/length cannot be changed
* concat - we are creating new from 2 string

> String name = firstName + " " + lastName;

> String conName = firstName.concat(" ").concat(lastName);

* StringBuilder allows string like objects that are immutable

sb.append(" ");

* StringBuffer is thread safe as its methods are synchronized.

## Normalize String input

> s.trim();, !s.isEmpty, s.toLowerCase()

## Data Access

> s.charAt(index);
> s.indexOf('a');
> s.substring(2,4); //inclusive of 2, exclusive of 4
> s.contains("abc")

> char[] arr = s.toCharArray();

sentences:
> s.split("\\.");// \\ is to use literal. character

words:
> s.split(" |-"); // space or dash

## String equality

based on how they are initialised

string literals
> String a = "abc";
> String b = "abc";

mostly same

with obj constructor
> String objA = new String("abc");
> String objB = new String("abc");

different.

use .equals() instead.




