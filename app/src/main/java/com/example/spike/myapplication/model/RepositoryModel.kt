package com.example.spike.myapplication.model

data class RepositoryModel (
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<RepositoryItem>
)