package com.emc.gs.eat.actors

import java.io.File

import com.emc.gs.eat.host.{Host, HostAnalysisResult}

import scala.concurrent.duration.Duration

sealed trait HostAnalysisMessage

case object ProcessHosts extends HostAnalysisMessage

case class AnalyzeHost(host: Host, index: Int, out: File) extends HostAnalysisMessage

case class AnalyzeHostResult(hostAnalysisResult: HostAnalysisResult) extends HostAnalysisMessage

case class AnalyzeHostError(host: Host, message: String, error: Option[Throwable])

case class AnalysisComplete(duration: Duration) extends HostAnalysisMessage

case class AnalysisFailed(message: String) extends HostAnalysisMessage
