package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.VideoEntity.AudioStreamEntity
import kr.camp.youtube.data.model.VideoEntity.ContentDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.ContentRatingEntity
import kr.camp.youtube.data.model.VideoEntity.FileDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.ItemEntity
import kr.camp.youtube.data.model.VideoEntity.LiveStreamingDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.LocalizationsEntity
import kr.camp.youtube.data.model.VideoEntity.LocalizedEntity
import kr.camp.youtube.data.model.VideoEntity.PageInfoEntity
import kr.camp.youtube.data.model.VideoEntity.PlayerEntity
import kr.camp.youtube.data.model.VideoEntity.ProcessingDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.ProcessingProgressEntity
import kr.camp.youtube.data.model.VideoEntity.RecordingDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.RegionRestrictionEntity
import kr.camp.youtube.data.model.VideoEntity.SnippetEntity
import kr.camp.youtube.data.model.VideoEntity.StatisticsEntity
import kr.camp.youtube.data.model.VideoEntity.StatusEntity
import kr.camp.youtube.data.model.VideoEntity.SuggestionsEntity
import kr.camp.youtube.data.model.VideoEntity.TagSuggestionEntity
import kr.camp.youtube.data.model.VideoEntity.ThumbnailsEntity
import kr.camp.youtube.data.model.VideoEntity.TopicDetailsEntity
import kr.camp.youtube.data.model.VideoEntity.VideoEntity
import kr.camp.youtube.data.model.VideoEntity.VideoStreamEntity
import kr.camp.youtube.data.model.VideoResponse.AudioStreamResponse
import kr.camp.youtube.data.model.VideoResponse.ContentDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.ContentRatingResponse
import kr.camp.youtube.data.model.VideoResponse.FileDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.ItemResponse
import kr.camp.youtube.data.model.VideoResponse.LiveStreamingDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.LocalizationsResponse
import kr.camp.youtube.data.model.VideoResponse.LocalizedResponse
import kr.camp.youtube.data.model.VideoResponse.PageInfoResponse
import kr.camp.youtube.data.model.VideoResponse.PlayerResponse
import kr.camp.youtube.data.model.VideoResponse.ProcessingDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.ProcessingProgressResponse
import kr.camp.youtube.data.model.VideoResponse.RecordingDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.RegionRestrictionResponse
import kr.camp.youtube.data.model.VideoResponse.SnippetResponse
import kr.camp.youtube.data.model.VideoResponse.StatisticsResponse
import kr.camp.youtube.data.model.VideoResponse.StatusResponse
import kr.camp.youtube.data.model.VideoResponse.SuggestionsResponse
import kr.camp.youtube.data.model.VideoResponse.TagSuggestionResponse
import kr.camp.youtube.data.model.VideoResponse.ThumbnailsResponse
import kr.camp.youtube.data.model.VideoResponse.TopicDetailsResponse
import kr.camp.youtube.data.model.VideoResponse.VideoResponse
import kr.camp.youtube.data.model.VideoResponse.VideoStreamResponse


fun VideoResponse.toEntity(): VideoEntity {
    return VideoEntity(
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
        contentDetails = contentDetails.toEntity(),
        etag = etag,
        fileDetails = fileDetails.toEntity(),
        id = id,
        kind = kind,
        liveStreamingDetails = liveStreamingDetails.toEntity(),
        localizations = localizations.toEntity(),
        player = player.toEntity(),
        processingDetails = processingDetails.toEntity(),
        recordingDetails = recordingDetails.toEntity(),
        snippet = snippet.toEntity(),
        statistics = statistics.toEntity(),
        status = status.toEntity(),
        suggestions = suggestions.toEntity(),
        topicDetails = topicDetails.toEntity()
    )
}

fun ContentDetailsResponse.toEntity(): ContentDetailsEntity {
    return ContentDetailsEntity(
        caption = caption,
        contentRating = contentRating.toEntity(),
        definition = definition,
        dimension = dimension,
        duration = duration,
        hasCustomThumbnail = hasCustomThumbnail,
        licensedContent = licensedContent,
        projection = projection,
        regionRestriction = regionRestriction.toEntity()
    )
}

fun ContentRatingResponse.toEntity(): ContentRatingEntity {
    return ContentRatingEntity(
        acbRating = acbRating,
        agcomRating = agcomRating,
        anatelRating = anatelRating,
        bbfcRating = bbfcRating,
        bfvcRating = bfvcRating,
        bmukkRating = bmukkRating,
        catvRating = catvRating,
        catvfrRating = catvfrRating,
        cbfcRating = cbfcRating,
        cccRating = cccRating,
        cceRating = cceRating,
        chfilmRating = chfilmRating,
        chvrsRating = chvrsRating,
        cicfRating = cicfRating,
        cnaRating = cnaRating,
        cncRating = cncRating,
        csaRating = csaRating,
        cscfRating = cscfRating,
        czfilmRating = czfilmRating,
        djctqRating = djctqRating,
        djctqRatingReasons = djctqRatingReasons,
        ecbmctRating = ecbmctRating,
        eefilmRating = eefilmRating,
        egfilmRating = egfilmRating,
        eirinRating = eirinRating,
        fcbmRating = fcbmRating,
        fcoRating = fcoRating,
        fmocRating = fmocRating,
        fpbRating = fpbRating,
        fpbRatingReasons = fpbRatingReasons,
        fskRating = fskRating,
        grfilmRating = grfilmRating,
        icaaRating = icaaRating,
        ifcoRating = ifcoRating,
        ilfilmRating = ilfilmRating,
        incaaRating = incaaRating,
        kfcbRating = kfcbRating,
        kijkwijzerRating = kijkwijzerRating,
        kmrbRating = kmrbRating,
        lsfRating = lsfRating,
        mccaaRating = mccaaRating,
        mccypRating = mccypRating,
        mcstRating = mcstRating,
        mdaRating = mdaRating,
        medietilsynetRating = medietilsynetRating,
        mekuRating = mekuRating,
        mibacRating = mibacRating,
        mocRating = mocRating,
        moctwRating = moctwRating,
        mpaaRating = mpaaRating,
        mpaatRating = mpaatRating,
        mtrcbRating = mtrcbRating,
        nbcRating = nbcRating,
        nbcplRating = nbcplRating,
        nfrcRating = nfrcRating,
        nfvcbRating = nfvcbRating,
        nkclvRating = nkclvRating,
        oflcRating = oflcRating,
        pefilmRating = pefilmRating,
        rcnofRating = rcnofRating,
        resorteviolenciaRating = resorteviolenciaRating,
        rtcRating = rtcRating,
        rteRating = rteRating,
        russiaRating = russiaRating,
        skfilmRating = skfilmRating,
        smaisRating = smaisRating,
        smsaRating = smsaRating,
        tvpgRating = tvpgRating,
        ytRating = ytRating
    )
}

fun RegionRestrictionResponse.toEntity(): RegionRestrictionEntity {
    return RegionRestrictionEntity(
        allowed = allowed,
        blocked = blocked
    )
}

fun FileDetailsResponse.toEntity(): FileDetailsEntity {
    return FileDetailsEntity(
        audioStreams = audioStreams.map(AudioStreamResponse::toEntity),
        bitrateBps = bitrateBps,
        container = container,
        creationTime = creationTime,
        durationMs = durationMs,
        fileName = fileName,
        fileSize = fileSize,
        fileType = fileType,
        videoStreams = videoStreams.map(VideoStreamResponse::toEntity)
    )
}

fun AudioStreamResponse.toEntity(): AudioStreamEntity {
    return AudioStreamEntity(
        bitrateBps = bitrateBps,
        channelCount = channelCount,
        codec = codec,
        vendor = vendor
    )
}

fun VideoStreamResponse.toEntity(): VideoStreamEntity {
    return VideoStreamEntity(
        aspectRatio = aspectRatio,
        bitrateBps = bitrateBps,
        codec = codec,
        frameRateFps = frameRateFps,
        heightPixels = heightPixels,
        rotation = rotation,
        vendor = vendor,
        widthPixels = widthPixels
    )
}

fun LiveStreamingDetailsResponse.toEntity(): LiveStreamingDetailsEntity {
    return LiveStreamingDetailsEntity(
        activeLiveChatId = activeLiveChatId,
        actualEndTime = actualEndTime,
        actualStartTime = actualStartTime,
        concurrentViewers = concurrentViewers,
        scheduledEndTime = scheduledEndTime,
        scheduledStartTime = scheduledStartTime
    )
}

fun LocalizationsResponse.toEntity(): LocalizationsEntity {
    return LocalizationsEntity(
        description = description,
        title = title
    )
}

fun PlayerResponse.toEntity(): PlayerEntity {
    return PlayerEntity(
        embedHeight = embedHeight,
        embedHtml = embedHtml,
        embedWidth = embedWidth
    )
}

fun ProcessingDetailsResponse.toEntity(): ProcessingDetailsEntity {
    return ProcessingDetailsEntity(
        editorSuggestionsAvailability = editorSuggestionsAvailability,
        fileDetailsAvailability = fileDetailsAvailability,
        processingFailureReason = processingFailureReason,
        processingIssuesAvailability = processingIssuesAvailability,
        processingProgress = processingProgress.toEntity(),
        processingStatus = processingStatus,
        tagSuggestionsAvailability = tagSuggestionsAvailability,
        thumbnailsAvailability = thumbnailsAvailability
    )
}

fun ProcessingProgressResponse.toEntity(): ProcessingProgressEntity {
    return ProcessingProgressEntity(
        partsProcessed = partsProcessed,
        partsTotal = partsTotal,
        timeLeftMs = timeLeftMs
    )
}

fun RecordingDetailsResponse.toEntity(): RecordingDetailsEntity {
    return RecordingDetailsEntity(
        recordingDate = recordingDate
    )
}

fun SnippetResponse.toEntity(): SnippetEntity {
    return SnippetEntity(
        categoryId = categoryId,
        channelId = channelId,
        channelTitle = channelTitle,
        defaultAudioLanguage = defaultAudioLanguage,
        defaultLanguage = defaultLanguage,
        description = description,
        liveBroadcastContent = liveBroadcastContent,
        localized = localized.toEntity(),
        publishedAt = publishedAt,
        tags = tags,
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
        commentCount = commentCount,
        dislikeCount = dislikeCount,
        favoriteCount = favoriteCount,
        likeCount = likeCount,
        viewCount = viewCount
    )
}

fun StatusResponse.toEntity(): StatusEntity {
    return StatusEntity(
        embeddable = embeddable,
        failureReason = failureReason,
        license = license,
        madeForKids = madeForKids,
        privacyStatus = privacyStatus,
        publicStatsViewable = publicStatsViewable,
        publishAt = publishAt,
        rejectionReason = rejectionReason,
        selfDeclaredMadeForKids = selfDeclaredMadeForKids,
        uploadStatus = uploadStatus
    )
}

fun SuggestionsResponse.toEntity(): SuggestionsEntity {
    return SuggestionsEntity(
        editorSuggestions = editorSuggestions,
        processingErrors = processingErrors,
        processingH1s = processingH1s,
        processingWarnings = processingWarnings,
        tagSuggestions = tagSuggestions.map(TagSuggestionResponse::toEntity)
    )
}

fun TagSuggestionResponse.toEntity(): TagSuggestionEntity {
    return TagSuggestionEntity(
        categoryRestricts = categoryRestricts,
        tag = tag
    )
}

fun TopicDetailsResponse.toEntity(): TopicDetailsEntity {
    return TopicDetailsEntity(
        relevantTopicIds = relevantTopicIds,
        topicCategories = topicCategories,
        topicIds = topicIds
    )
}
