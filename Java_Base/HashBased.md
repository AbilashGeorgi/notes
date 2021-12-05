* HashTables
* HashSets
* HashMap

## HashMap
provides most flexibility, allowing duplicate values and null key

Not Synchronized so better performance than table but not thread safe.

consists of key value pairs

hashing function maps key to hash

hash determines where the object is stored

as long as you have key, retrieving is fast.

Hash Collisions - use list for all values in a key.

java.util.HashMap;

> put(key, value)
> get(key)
> hashMap.values()
> hashMap.keySet()
> remove(key)

* order is not guaranteed

