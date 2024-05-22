package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.search.IdResponse
import kr.camp.youtube.data.model.search.ItemResponse
import kr.camp.youtube.data.model.search.PageInfoResponse
import kr.camp.youtube.data.model.search.SearchResponse
import kr.camp.youtube.data.model.search.SnippetResponse
import kr.camp.youtube.data.model.search.ThumbnailResponse
import kr.camp.youtube.data.model.search.ThumbnailsResponse
import kr.camp.youtube.domain.model.search.IdEntity
import kr.camp.youtube.domain.model.search.ItemEntity
import kr.camp.youtube.domain.model.search.PageInfoEntity
import kr.camp.youtube.domain.model.search.SearchEntity
import kr.camp.youtube.domain.model.search.SnippetEntity
import kr.camp.youtube.domain.model.search.ThumbnailEntity
import kr.camp.youtube.domain.model.search.ThumbnailsEntity

fun SearchResponse.toEntity(): SearchEntity {
    return SearchEntity(
        kind = kind,
        eTag = eTag,
        nextPageToken = nextPageToken,
        prevPageToken = prevPageToken,
        regionCode = regionCode,
        pageInfo = pageInfo?.toEntity(),
        items = items.map(ItemResponse::toEntity),
    )
}

fun PageInfoResponse.toEntity(): PageInfoEntity {
    return PageInfoEntity(
        totalResults = totalResults,
        resultsPerPage = resultsPerPage
    )
}

fun ItemResponse.toEntity(): ItemEntity {
    return ItemEntity(
        kind = kind,
        eTag = eTag,
        id = id?.toEntity(),
        snippet = snippet.toEntity()
    )
}

fun IdResponse.toEntity(): IdEntity {
    return IdEntity(
        kind = kind,
        videoId = videoId
    )
}

fun SnippetResponse.toEntity(): SnippetEntity {
    return SnippetEntity(
        publishedAt = publishedAt,
        channelId = channelId,
        title = title,
        description = description,
        thumbnails = thumbnails.toEntity(),
        channelTitle = channelTitle,
        liveBroadcastContent = liveBroadcastContent,
        publishTime = publishTime
    )
}

fun ThumbnailsResponse.toEntity(): ThumbnailsEntity {
    return ThumbnailsEntity(
        default = default.toEntity(),
        medium = medium.toEntity(),
        high = high.toEntity()
    )
}

fun ThumbnailResponse.toEntity(): ThumbnailEntity {
    return ThumbnailEntity(
        url = url,
        height = height,
        width = width
    )
}