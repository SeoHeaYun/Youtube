package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.video.DefaultResponce
import kr.camp.youtube.data.model.video.HighResponce
import kr.camp.youtube.data.model.video.ItemResponce
import kr.camp.youtube.data.model.video.LocalizedResponce
import kr.camp.youtube.data.model.video.MaxresResponce
import kr.camp.youtube.data.model.video.MediumResponce
import kr.camp.youtube.data.model.video.PageInfoResponce
import kr.camp.youtube.data.model.video.SnippetResponce
import kr.camp.youtube.data.model.video.StandardResponce
import kr.camp.youtube.data.model.video.ThumbnailsResponce
import kr.camp.youtube.data.model.video.VideoResponce
import kr.camp.youtube.domain.model.video.DefaultEntity
import kr.camp.youtube.domain.model.video.HighEntity
import kr.camp.youtube.domain.model.video.ItemEntity
import kr.camp.youtube.domain.model.video.LocalizedEntity
import kr.camp.youtube.domain.model.video.MaxresEntity
import kr.camp.youtube.domain.model.video.MediumEntity
import kr.camp.youtube.domain.model.video.PageInfoEntity
import kr.camp.youtube.domain.model.video.SnippetEntity
import kr.camp.youtube.domain.model.video.StandardEntity
import kr.camp.youtube.domain.model.video.ThumbnailsEntity
import kr.camp.youtube.domain.model.video.VideoEntity

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


