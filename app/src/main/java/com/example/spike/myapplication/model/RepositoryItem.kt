package com.example.spike.myapplication.model

data class RepositoryItem (
        val id: Long,
        val name: String,
        val full_name: String,
        val owner: RepositoryOwner,
        val html_url: String,
        val description: String,
        val stargazers_count: Long,
        val forks_count: Long,
        val language: String
)