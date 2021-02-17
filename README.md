## PCF Usage Dashboard CLI

Command Line Interface (CLI) built using [Micronaut](https://docs.micronaut.io/) and [picocli](https://picocli.info/) to provide a quick exploratory tool for architects and developers working on migration efforts.

**NOTE:** For now this is mostly a skeleton, so detail usage coming soon!

```
       __                                     _ _ 
      / _|                                   | (_)
  ___| |_   _   _ ___  __ _  __ _  ___    ___| |_ 
 / __|  _| | | | / __|/ _` |/ _` |/ _ \  / __| | |
| (__| |   | |_| \__ \ (_| | (_| |  __/ | (__| | |
 \___|_|    \__,_|___/\__,_|\__, |\___|  \___|_|_|
                           __/ |                
                          |___/                  
Usage: cfucli [-hvV] [COMMAND]
Interacts wiht PCF Usage Dashboard APIs
  -h, --help      Show this help message and exit.
  -v, --verbose   Shows the response body
  -V, --version   Print version information and exit.
Commands:
  org  provide organization information
  app  provide application information
```

