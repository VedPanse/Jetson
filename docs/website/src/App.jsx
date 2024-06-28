import './App.css';
import Navbar from './components/Navbar/Navbar.jsx';
import LeftNav from "./components/LeftNav.jsx";

function App() {
    let active = "Home";
    let leftNavWidth = 2;

  return (
    <>
        <Navbar/>
        <div className="row" id="parent">
            <LeftNav active={active} leftNavWidth={leftNavWidth} />
        </div>
    </>
  )
}

export default App
