package com.unchartedsoftware.mosaic.core.generation.request

import com.unchartedsoftware.mosaic.core.projection.Projection

/**
 * A TileRequest which takes the form of a Seq of zoom levels,
 * generating all tiles at those levels.
 */
class TileLevelRequest[TC](inLevels: Seq[Int], projection: Projection[TC]) extends TileRequest[TC] {

  private val _levelMap = inLevels.map(c => (c, true)).toMap

  /**
   * @return true, if the given tile coordinate is part of this request. false otherwise.
   */
  def inRequest(tile: TC): Boolean = {
    _levelMap.contains(projection.getZoomLevel(tile))
  }

  /**
   * @return a Seq of all zoom levels which contain tile coordinates in this request
   */
  def levels(): Seq[Int] = {
    inLevels
  }
}
