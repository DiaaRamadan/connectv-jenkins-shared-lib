#!/usr/bin/env groovy

import com.jenkins.Git

def call() {
    return new Git(this).commitVersionUpdated()
}