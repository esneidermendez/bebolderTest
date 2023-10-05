import logo from './logo.svg';
import './App.css';
import Formulario from './Formulario';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Container } from 'react-bootstrap';
function App() {
  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#">Realizar pago PSE </Navbar.Brand>
        </Container>
        
      </Navbar>
      <Container>
        <img src={logo} className="App-logo" alt="logo" />
        <h1>
          Formulario para realizar pago PSE 
        </h1>
          <Formulario />
        </Container>
    </div>
  );
}

export default App;
