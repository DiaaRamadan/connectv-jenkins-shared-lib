#!/usr/bin/env groovy

package com.jenkins.Maven

class MavenVersion implements Serializable {

    def script

    MavenVersion(script){
        this.script = script
    }

    def incrementPatchVersion(){
        script.echo "Increment app version..."
        script.sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
    }

}