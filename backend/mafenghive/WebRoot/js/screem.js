(function (doc, win, basicFontSize, layoutWidth) {
        var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
                docEl.style.fontSize = basicFontSize * (clientWidth / layoutWidth) + 'px';
            };
        if (!doc.addEventListener) return;

            win.addEventListener(resizeEvt, recalc, false);

            doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window, 100, 320);