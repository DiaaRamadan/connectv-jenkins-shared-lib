#!/usr/bin/env groovy

package com.jenkins

class Git implements Serializable {

    def script

    Git(script) {
        this.script = script
    }

    def commitVersionUpdated() {
        script.withCredentials([script.usernamePassword(credentialsId: 'github-token', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh 'git config --global user.email "jenkins@example.com"'
            script.sh 'git config --global user.name "jenkins"'

            script.sh 'git status'
            script.sh 'git branch'
            script.sh 'git config --list'

            script.sh "git remote set-url origin https://${script.PASS}@github.com/DiaaRamadan/connectv-jenkins-shared-lib.git"
            script.sh 'git add .'
            script.sh 'git commit -m "ci:Version bump"'
            script.sh 'git push origin HEAD:master'
        }
    }

}
