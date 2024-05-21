package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.ChannelsEntity.BrandingSettingsEntity
import kr.camp.youtube.data.model.ChannelsEntity.ContentDetailsEntity
import kr.camp.youtube.data.model.ChannelsEntity.ContentOwnerDetailsEntity
import kr.camp.youtube.data.model.ChannelsEntity.ItemEntity
import kr.camp.youtube.data.model.ChannelsEntity.LocalizationsEntity
import kr.camp.youtube.data.model.ChannelsEntity.LocalizedEntity
import kr.camp.youtube.data.model.ChannelsEntity.PageInfoEntity
import kr.camp.youtube.data.model.ChannelsEntity.RelatedPlaylistsEntity
import kr.camp.youtube.data.model.ChannelsEntity.SnippetEntity
import kr.camp.youtube.data.model.ChannelsEntity.StatisticsEntity
import kr.camp.youtube.data.model.ChannelsEntity.StatusEntity
import kr.camp.youtube.data.model.ChannelsEntity.ThumbnailsEntity
import kr.camp.youtube.data.model.ChannelsEntity.TopicDetailsEntity
import kr.camp.youtube.data.model.ChannelsEntity.WatchEntity
import kr.camp.youtube.data.model.ChannelsResponce.AuditDetailsEntity
import kr.camp.youtube.data.model.ChannelsResponce.ChannelEntity
import kr.camp.youtube.data.model.ChannelsResponce.ChannelsEntity
import kr.camp.youtube.data.model.ChannelsResponse.AuditDetailsResponse
import kr.camp.youtube.data.model.ChannelsResponse.BrandingSettingsResponse
import kr.camp.youtube.data.model.ChannelsResponse.ChannelResponse
import kr.camp.youtube.data.model.ChannelsResponse.ChannelsResponse
import kr.camp.youtube.data.model.ChannelsResponse.ContentDetailsResponse
import kr.camp.youtube.data.model.ChannelsResponse.ContentOwnerDetailsResponse
import kr.camp.youtube.data.model.ChannelsResponse.ItemResponse
import kr.camp.youtube.data.model.ChannelsResponse.LocalizationsResponse
import kr.camp.youtube.data.model.ChannelsResponse.LocalizedResponse
import kr.camp.youtube.data.model.ChannelsResponse.PageInfoResponse
import kr.camp.youtube.data.model.ChannelsResponse.RelatedPlaylistsResponse
import kr.camp.youtube.data.model.ChannelsResponse.SnippetResponse
import kr.camp.youtube.data.model.ChannelsResponse.StatisticsResponse
import kr.camp.youtube.data.model.ChannelsResponse.StatusResponse
import kr.camp.youtube.data.model.ChannelsResponse.ThumbnailsResponse
import kr.camp.youtube.data.model.ChannelsResponse.TopicDetailsResponse
import kr.camp.youtube.data.model.ChannelsResponse.WatchResponse


fun ChannelsResponse.toEntity(): ChannelsEntity {
    return ChannelsEntity(
        etag = etag,
        items = items.map(ItemResponse::toEntity),
        kind = kind,
        nextPageToken = nextPageToken,
        pageInfo = pageInfo.toEntity(),
        prevPageToken = prevPageToken
    )
}

fun PageInfoResponse.toEntity(): PageInfoEntity {
    return PageInfoEntity(
        resultsPerPage = resultsPerPage,
        totalResults = totalResults
    )
}

fun ItemResponse.toEntity(): ItemEntity {
    return ItemEntity(
        auditDetails = auditDetails.toEntity(),
        brandingSettings = brandingSettings.toEntity(),
        contentDetails = contentDetails.toEntity(),
        contentOwnerDetails = contentOwnerDetails.toEntity(),
        etag = etag,
        id = id,
        kind = kind,
        localizations = localizations.toEntity(),
        snippet = snippet.toEntity(),
        statistics = statistics.toEntity(),
        status = status.toEntity(),
        topicDetails = topicDetails.toEntity(),
    )
}

fun AuditDetailsResponse.toEntity(): AuditDetailsEntity {
    return AuditDetailsEntity(
        communityGuidelinesGoodStanding = communityGuidelinesGoodStanding,
        contentIdClaimsGoodStanding = contentIdClaimsGoodStanding,
        copyrightStrikesGoodStanding = copyrightStrikesGoodStanding,
        overallGoodStanding = overallGoodStanding
    )
}

fun BrandingSettingsResponse.toEntity(): BrandingSettingsEntity {
    return BrandingSettingsEntity(
        channel = channel.toEntity(),
        watch = watch.toEntity()
    )
}

fun ChannelResponse.toEntity(): ChannelEntity {
    return ChannelEntity(
        country = country,
        defaultLanguage = defaultLanguage,
        description = description,
        keywords = keywords,
        title = title,
        trackingAnalyticsAccountId = trackingAnalyticsAccountId,
        unsubscribedTrailer = unsubscribedTrailer
    )
}

fun WatchResponse.toEntity(): WatchEntity {
    return WatchEntity(
        backgroundColor = backgroundColor,
        featuredPlaylistId = featuredPlaylistId,
        textColor = textColor
    )
}

fun ContentDetailsResponse.toEntity(): ContentDetailsEntity {
    return ContentDetailsEntity(
        relatedPlaylists = relatedPlaylists.toEntity()
    )
}

fun RelatedPlaylistsResponse.toEntity(): RelatedPlaylistsEntity {
    return RelatedPlaylistsEntity(
        favorites = favorites,
        likes = likes,
        uploads = uploads
    )
}


fun ContentOwnerDetailsResponse.toEntity(): ContentOwnerDetailsEntity {
    return ContentOwnerDetailsEntity(
        contentOwner = contentOwner,
        timeLinked = timeLinked
    )
}

fun LocalizationsResponse.toEntity(): LocalizationsEntity {
    return LocalizationsEntity(
        description = description,
        title = title
    )
}

fun SnippetResponse.toEntity(): SnippetEntity {
    return SnippetEntity(
        country = country,
        customUrl = customUrl,
        defaultLanguage = defaultLanguage,
        description = description,
        localized = localized.toEntity(),
        publishedAt = publishedAt,
        thumbnails = thumbnails.toEntity(),
        title = title
    )
}

fun LocalizedResponse.toEntity(): LocalizedEntity {
    return LocalizedEntity(
        description = description,
        title = title
    )
}

fun ThumbnailsResponse.toEntity(): ThumbnailsEntity {
    return ThumbnailsEntity(
        height = height,
        url = url,
        width = width
    )
}

fun StatisticsResponse.toEntity(): StatisticsEntity {
    return StatisticsEntity(
        hiddenSubscriberCount = hiddenSubscriberCount,
        subscriberCount = subscriberCount,
        videoCount = videoCount,
        viewCount = viewCount
    )
}

fun StatusResponse.toEntity(): StatusEntity {
    return StatusEntity(
        isLinked = isLinked,
        longUploadsStatus = longUploadsStatus,
        madeForKids = madeForKids,
        privacyStatus = privacyStatus,
        selfDeclaredMadeForKids = selfDeclaredMadeForKids
    )
}

fun TopicDetailsResponse.toEntity(): TopicDetailsEntity {
    return TopicDetailsEntity(
        topicCategories = topicCategories,
        topicIds = topicIds
    )
}