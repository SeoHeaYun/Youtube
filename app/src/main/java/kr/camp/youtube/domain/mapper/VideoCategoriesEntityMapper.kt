package kr.camp.youtube.domain.mapper

import kr.camp.youtube.data.model.VideoCategoriesEntity.ItemEntity
import kr.camp.youtube.data.model.VideoCategoriesEntity.PageInfoEntity
import kr.camp.youtube.data.model.VideoCategoriesEntity.SnippetEntity
import kr.camp.youtube.data.model.VideoCategoriesEntity.VideoCategoriesEntity
import kr.camp.youtube.data.model.VideoCategoriesResponse.ItemResponse
import kr.camp.youtube.data.model.VideoCategoriesresponse.PageInfoResponse
import kr.camp.youtube.data.model.VideoCategoriesresponse.SnippetResponse
import kr.camp.youtube.data.model.VideoCategoriesresponse.VideoCategoriesResponse

fun VideoCategoriesResponse.toEntity(): VideoCategoriesEntity {
    return VideoCategoriesEntity(
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
        etag = etag,
        id = id,
        kind = kind,
        snippet = snippet.toEntity()
    )
}

fun SnippetResponse.toEntity(): SnippetEntity {
    return SnippetEntity(
        assignable = assignable,
        channelId = channelId,
        title = title
    )
}

