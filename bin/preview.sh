#!/usr/bin/env bash
#
# Previews cljs-template
#

# Remove old preview version
rm -rf preview

# Build template
echo "Rebuilding template"
boot build

# Create new preview project
echo "Generating new preview build"
boot -d boot/new new -t cljs-template -n preview --snapshot

echo "Done!"
