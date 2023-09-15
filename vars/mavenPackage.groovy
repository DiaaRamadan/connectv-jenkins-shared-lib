#!/usr/bin/env groovy

import com.jenkins.Maven

def call() {
    return new Maven(this).mavenPackage()
}