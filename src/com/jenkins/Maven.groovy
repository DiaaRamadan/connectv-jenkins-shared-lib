#!/usr/bin/env groovy

package com.jenkins

class Maven implements Serializable {

    def script

    Maven(script) {
        this.script = script
    }

    def incrementPatchVersion() {
        script.echo "Increment app version..."
        script.sh 'mvn -f ./backend build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
    }

    def buildJar() {
        script.sh 'mvn -f ./backend clean package'
    }

    def pomVersion(String path) {
        def pomContent = script.readFile(path) =~ '<version>(.+)</version>'
        def version = pomContent[1][1]
        return version
    }

}