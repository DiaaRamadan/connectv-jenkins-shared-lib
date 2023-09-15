#!/usr/bin/env groovy

import com.jenkins.Maven.MavenVersion

def call(String imageName, String path) {
    return new MavenVersion(this).incrementPatchVersion()
}