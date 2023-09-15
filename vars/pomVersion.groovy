#!/usr/bin/env groovy

import com.jenkins.Maven

def call(String path) {
    return new Maven(this).pomVersion(path)
}