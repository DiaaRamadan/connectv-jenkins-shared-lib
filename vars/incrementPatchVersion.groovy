#!/usr/bin/env groovy

import com.jenkins.Maven.MavenVersion

def call() {
    return new MavenVersion(this).incrementPatchVersion()
}