/*!
Copyright (c) REBUILD <https://getrebuild.com/> and/or its owners. All rights reserved.

rebuild is dual-licensed under commercial and open source licenses (GPLv3).
See LICENSE and COMMERCIAL in the project root for license information.
*/
/* global introJs */

window.startTour = function (delay) {
  if ($(window).width() < 1000) return
  if ($.cookie('rb.TourEnd')) return
  setTimeout(startTour123, delay || 100)
}

const wpc = window.__PageConfig || {}
const startTour123 = function () {
  let stepName
  let steps
  if (location.href.includes('/dashboard/home')) {
    stepName = 'TourEnd-Dashboard'
    steps = StepRebuild()
    // isEnd
    if ($storage.get(stepName)) {
      stepName = 'TourEnd-Dashboard2'
      steps = StepDashboard()
    }
  } else if (location.href.includes('/list') && wpc.type === 'RecordList') {
    if ($('.datalist-mode2')[0]) {
      stepName = 'TourEnd-RecordList2'
      steps = StepDataList2()
    } else if ($('.datalist-mode3')[0]) {
      stepName = 'TourEnd-RecordList3'
      steps = StepDataList3()
    } else {
      stepName = 'TourEnd-RecordList'
      steps = StepDataList()
    }
  } else if (location.href.includes('/view') && wpc.type === 'RecordView') {
    stepName = 'TourEnd-RecordView'
    steps = StepView()
  } else if (location.href.includes('/dashboard/chart-design')) {
    stepName = 'TourEnd-Chart'
    steps = StepChart()
  } else if (location.href.includes('/project/') && location.href.includes('/tasks')) {
    stepName = 'TourEnd-Project'
    steps = StepProject()
  }

  if (!steps) return

  const isEnd = $storage.get(stepName)
  if (isEnd) return // 已经展示完

  const stepsObj = []
  steps.forEach((item) => {
    const $el = item.element ? $(item.element) : [null]
    if ($el.length > 0) stepsObj.push({ ...item, element: $el[0] })
  })
  if (stepsObj.length === 0) return

  window.tourStarted = stepName
  // 隐藏滚动条
  $(document.body).addClass('rebuild-tour-body')

  let _oncomplete = false
  const $introJs = introJs()
    .setOptions({
      steps: stepsObj,
      overlayOpacity: 0,
      disableInteraction: true,
      exitOnOverlayClick: false,
      exitOnEsc: false,
      scrollToElement: false,
      tooltipClass: 'rebuild-tour-tooltip',
      highlightClass: 'rebuild-tour-highlight',
      prevLabel: '<i class="zmdi zmdi-arrow-left down-2"></i>',
      nextLabel: '<i class="zmdi zmdi-arrow-right down-2"></i>',
      doneLabel: $L('知道了'),
    })
    .onchange((target) => {
      const $target = $(target)
      let stepIndex = -1
      for (let i = 0; i < steps.length; i++) {
        if (steps[i].element && $target.hasClass(steps[i].element.substr(1))) {
          stepIndex = i
          break
        }
      }
      if (stepIndex < 0) return

      // hack: 位置更新
      $('.rebuild-tour-highlight').css('box-shadow', 'none')
      const pos = { margin: 0 }
      const s = steps[stepIndex]
      if (s && s.rbLeft) pos.marginLeft = s.rbLeft
      else if (s && s.rbRight) pos.marginRight = s.rbRight
      if (s && s.rbTop) pos.marginTop = s.rbTop
      else if (s && s.rbBottom) pos.marginBottom = s.rbBottom
      setTimeout(() => $('.rebuild-tour-tooltip').css(pos), stepIndex === 0 ? 1 : 360)

      // $introJs.refresh()
    })
    .oncomplete(() => {
      _oncomplete = true
      $storage.set(stepName, 'yes')
    })
    .onexit(() => {
      window.tourStarted = undefined
      $(document.body).removeClass('rebuild-tour-body')

      if (!_oncomplete) {
        $.cookie('rb.TourEnd', 'session', { expires: null })
      }
    })

  // $introJs.goToStep(1)
  $introJs.start()
}

// ~~ 向导步骤
