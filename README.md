# cljs-template

A boot template for cljs projects & POC's.

## Features

## Usage

The first step is to build `cljs-template` locally. To do this, run `boot build` in the root of the `cljs-template` project.

Once the project is built on your machine, you are then able to run the following from any directory to create an Aptive project.

`boot -d boot/new new -t cljs-template -n {{ name }} --snapshot`

## Development

You can modify the template and test it out locally by running the following from the project root.

`./bin/preview.sh`

## Tests

boot test

## License

Copyright © 2017 Matt O'Connell
