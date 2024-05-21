package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.VideoResponce.DefaultResponce
import kr.camp.youtube.data.model.VideoResponce.HighResponce
import kr.camp.youtube.data.model.VideoResponce.ItemResponce
import kr.camp.youtube.data.model.VideoResponce.LocalizedResponce
import kr.camp.youtube.data.model.VideoResponce.MaxresResponce
import kr.camp.youtube.data.model.VideoResponce.MediumResponce
import kr.camp.youtube.data.model.VideoResponce.PageInfoResponce
import kr.camp.youtube.data.model.VideoResponce.SnippetResponce
import kr.camp.youtube.data.model.VideoResponce.StandardResponce
import kr.camp.youtube.data.model.VideoResponce.ThumbnailsResponce
import kr.camp.youtube.data.model.VideoResponce.VideoResponce
import kr.camp.youtube.domain.model.VideoEntity.DefaultEntity
import kr.camp.youtube.domain.model.VideoEntity.HighEntity
import kr.camp.youtube.domain.model.VideoEntity.ItemEntity
import kr.camp.youtube.domain.model.VideoEntity.LocalizedEntity
import kr.camp.youtube.domain.model.VideoEntity.MaxresEntity
import kr.camp.youtube.domain.model.VideoEntity.MediumEntity
import kr.camp.youtube.domain.model.VideoEntity.PageInfoEntity
import kr.camp.youtube.domain.model.VideoEntity.SnippetEntity
import kr.camp.youtube.domain.model.VideoEntity.StandardEntity
import kr.camp.youtube.domain.model.VideoEntity.ThumbnailsEntity
import kr.camp.youtube.domain.model.VideoEntity.VideoEntity

fun VideoResponce.toEntity(): VideoEntity {
    return VideoEntity(
        etag = etag,
        items = items.map(ItemResponce::toEntity),
        kind = kind,
        nextPageToken = nextPageToken,
        pageInfo = pageInfo?.toEntity()
    )
}

fun ItemResponce.toEntity(): ItemEntity {
    return ItemEntity(
        etag = etag,
        id = id,
        kind = kind,
        snippet = snippet.toEntity()
    )
}

fun SnippetResponce.toEntity(): SnippetEntity {
    return SnippetEntity(
        categoryId = categoryId,
        channelId = channelId,
        channelTitle = channelTitle,
        defaultAudioLanguage = defaultAudioLanguage,
        description = description,
        liveBroadcastContent = liveBroadcastContent,
        localized = localized.toEntity(),
        publishedAt = publishedAt,
        tags = tags,
        thumbnails = thumbnails.toEntity(),
        title = title
    )
}

fun LocalizedResponce.toEntity(): LocalizedEntity {
    return LocalizedEntity(
        description = description,
        title = title
    )
}

fun ThumbnailsResponce.toEntity(): ThumbnailsEntity {
    return ThumbnailsEntity(
        default = default.toEntity(),
        high = high.toEntity(),
        maxres = maxres?.toEntity(),
        medium = medium?.toEntity(),
        standard = standard?.toEntity()
    )
}

fun DefaultResponce.toEntity(): DefaultEntity {
    return DefaultEntity(
        height = height,
        url = url,
        width = width
    )
}

fun HighResponce.toEntity(): HighEntity {
    return HighEntity(
        height = height,
        url = url,
        width = width
    )
}

fun MaxresResponce.toEntity(): MaxresEntity {
    return MaxresEntity(
        height = height,
        url = url,
        width = width
    )
}

fun MediumResponce.toEntity(): MediumEntity {
    return MediumEntity(
        height = height,
        url = url,
        width = width
    )
}

fun StandardResponce.toEntity(): StandardEntity {
    return StandardEntity(
        height = height,
        url = url,
        width = width
    )
}

fun PageInfoResponce.toEntity(): PageInfoEntity {
    return PageInfoEntity(
        resultsPerPage = resultsPerPage,
        totalResults = totalResults
    )
}


