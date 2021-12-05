* everything is a sqlexception
* not something to ignore

## common unpacking
* unpack sql exception into your own named exceptions
* log error codes
* create named exceptions for common issues
* create generic for rest

## Runtime
* convert everything to rte either generic or extensions

* don't have to catch everywhere
* allow to bubble and catch at top and transform
* log when you convert to runtime
* no leaky APIs

## Leak
* allow SQLException to bubble up.
* each method signature must declare or handle it.
