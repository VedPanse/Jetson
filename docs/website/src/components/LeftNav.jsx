export default function LeftNav({active, leftNavWidth}) {
    return <>
    <div className={"col-lg-" + leftNavWidth + " col-md-2"} id="left-nav">
        <a href="#">Getting Started</a>
        <a href="#">Starting a project</a>
    </div>
    </>
}