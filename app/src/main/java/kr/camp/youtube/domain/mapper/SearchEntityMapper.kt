package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.IdResponse
import kr.camp.youtube.data.model.ItemResponse
import kr.camp.youtube.data.model.PageInfoResponse
import kr.camp.youtube.data.model.SearchResponse
import kr.camp.youtube.data.model.SnippetResponse
import kr.camp.youtube.data.model.ThumbnailResponse
import kr.camp.youtube.data.model.ThumbnailsResponse
import kr.camp.youtube.domain.model.IdEntity
import kr.camp.youtube.domain.model.ItemEntity
import kr.camp.youtube.domain.model.PageInfoEntity
import kr.camp.youtube.domain.model.SearchEntity
import kr.camp.youtube.domain.model.SnippetEntity
import kr.camp.youtube.domain.model.ThumbnailEntity
import kr.camp.youtube.domain.model.ThumbnailsEntity

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