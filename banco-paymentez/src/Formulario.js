import React, { Component } from 'react';
import { Button, Form, Row, Col } from 'react-bootstrap';
        
class Formulario extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            document_type: 'CC',
            identification_number: '',
            person_type: 'N',
            bank: '',
            opciones:{
                banks:[]
            }
            
        };
    }
    componentDidMount(){
        fetch('http://localhost:8080/get/bank')
            .then(response =>{
                if(!response.ok){
                    throw new Error('No conecto a la micro');
                }
                return response.json()})
            .then(({banks}) => {
                this.setState({opciones: banks})
            })
            .catch(error =>{
               console.error('Error al obtener bancos ',error);
             });
    }
    handleChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    }
    handleSubmit = (e) => {
        e.preventDefault();
        console.log("Datos del formulario", this.state.bank);
    }
    requiredFields(){
        const { name, surname, document_type, identification_number, person_type, bank} = this.state;
        return name.trim()!==''&& surname.trim()!==''&& document_type.trim()!==''&& identification_number.trim()!==''&& person_type.trim()!==''&& bank.trim()!=='';
    }

    render() {
        return (

            <Form onSubmit={this.handleSubmit}>
                <Row>
                    <Col md="6">
                    <Form.Group controlID="document_type">
                            <Form.Label>Tipo de identificación</Form.Label>
                            <Form.Control as="select"
                                name="document_type"
                                value={this.state.document_type}
                                onChange={this.handleChange}
                                required
                            >
                            <option>Seleccionar tipo de documento</option>
                            <option value="CC">CC</option>
                            <option value="CE">CE</option>
                            <option value="PEP">PEP</option>
                            </Form.Control>
                        </Form.Group>
                    </Col>

                    <Col md="6">
                        <Form.Group controlID="identification_number">
                            <Form.Label>Número de identificación</Form.Label>
                            <Form.Control
                                type="Text"
                                name="identification_number"
                                value={this.state.identification_number}
                                onChange={this.handleChange}
                                placeholder='Ingresar número de identificación'
                            />
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col md="6">
                        <Form.Group controlID="name">
                            <Form.Label>Nombre</Form.Label>
                            <Form.Control
                                type="Text"
                                name="name"
                                value={this.state.name}
                                onChange={this.handleChange}
                                required
                                placeholder='Ingresar nombre'
                            />
                        </Form.Group>
                    </Col>
                    <Col md="6">
                        <Form.Group controlID="surname">
                            <Form.Label>Apellidos</Form.Label>
                            <Form.Control
                                type="Text"
                                name="surname"
                                value={this.state.surname}
                                onChange={this.handleChange}
                                required
                                placeholder='Ingresar Apellido'
                            />
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col md="12">
                        <Form.Group controlID="person_type">
                            <Form.Label>Tipo de persona</Form.Label>
                            <Form.Control as="select"
                                name="person_type"
                                value={this.state.person_type}
                                onChange={this.handleChange}
                            >
                            <option value="N">Persona natural</option>
                            <option value="J">Persona juridica</option>
                            </Form.Control>
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col md="12">
                    <Form.Group controlID="bank">
                            <Form.Label>Entidad Bancaria</Form.Label>
                            <Form.Control as="select"
                                name="bank"
                                value={this.state.bank}
                                onChange={this.handleChange}
                                required
                            >{Array.isArray(this.state.opciones) ? (this.state.opciones.map(opcion => (
                                <option key={opcion.code} value={opcion.code}>{opcion.name}</option>
                                ))):(<option value="">Cargando bancos...</option>)}    
                            </Form.Control>
                        </Form.Group>
                    </Col>
                </Row>


                <Button variant='primary' type='submit' disabled={!this.requiredFields()}>Realizar Pago PSE</Button>
            </Form>
        );
    }
}
export default Formulario;