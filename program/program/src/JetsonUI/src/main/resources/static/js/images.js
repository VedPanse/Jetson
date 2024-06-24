document.addEventListener("DOMContentLoaded", () => {
    const middleElement = document.querySelector("div#middle");
    const middleWidth = middleElement.clientWidth;
    const largeWidthPercent = 0.6;

    let idealHeight;

    document.querySelectorAll("div.card.large").forEach((card) => {
        let thisWidth = middleWidth * largeWidthPercent;
        let thisHeight = thisWidth * (1 - largeWidthPercent);

        card.style.width = thisWidth + "px";
        card.style.height = thisHeight + "px";

        idealHeight = thisHeight;
    });

    document.querySelectorAll("div.card.small").forEach((card) => {
       card.style.width = idealHeight + "px";
       card.style.height = idealHeight + "px";
    });
});